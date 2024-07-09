
### completaleFuture简介

使用Future的缺点：     
+ 在没有阻塞的情况下，无法对Future的结果执行进一步的操作，future不会告诉你他什么时候完成，如果想要得到结果，必须通过get()方法，该方法会阻塞直到结果可用为止，他不具备将回调函数附加到Future后并在Future结果可用时自动调用回调的能力
+ 无法解决任务互相依赖的问题 ,不能轻而易举地创建异步工作流
+ 不能将多个Future合并在一起
+ 没有异常处理

CompletableFuture的优势     
+ 提供了适用于各种开发场景的回调函数，还提供了非常全面的异常处理机制
+ 无缝衔接lambda表达式和stream API
+ 把异步编程  函数式编程  响应式编程集于一身

创建异步任务    
CompletableFuture.runAsync()
[CompletableFuture简介](https://juejin.cn/post/7209612932367089719)
CompletableFuture是有Java8引入的，之前一般使用Future实现异步。Future表示异步计算的结果，只能通过阻塞或者轮询的方式获取结果，而且不支持回调方法，Java8之前若要设置回调一般会使用guava的ListenableFuture

CompletableFuture实现了两个接口，Future<T>  CompletionStage<T> 意味着可以像之前一样通过阻塞或者轮询的方式获得结果，Future表示异步计算的结果，CompletionStage<T> 用于表示异步执行过程中的一个步骤Stage，这个步骤可能是由另外一个CompletionStage触发的，随着当前步骤的完成，也可能会触发其它一系列CompletionStage的执行

多重依赖 可以通过allOf() 或 anyOf()实现。，区别是当需要多个依赖全部完成时使用allOf(),当多个依赖中的的任意一个完成即可使用anyOf(),
```
CompletableFuture<Void> future6=CompletableFuture.allOf(Future3,Future4,Future5);
COmpletableFuture<String> result = Future6.thenApply(v->{
// 这里join并不会阻塞，因为传给thenApply的函数是在Future3 Future4 Future5全部完成时，才会执行
  Future3.join();
  Future4.join();
  Future5.join();
  return assamble(result3,result4,result5);
});
```

异步编排API:
+ thenRun: 执行直接开启一个异步线程执行任务，不接收任何参数，回调方法没有返回值
+ thenApply: 可以返回返回值，接收上一个任务的执行结果，作为下一个Future的入参，回调方法是有返回值的
+ thenAccept:可以接收上一个任务的执行结果，作为下一个Future的入参，回调方法是没有返回值的
+ thenCombine: 可以结合不同的Future的返回值，作为下一个Future的入参，回调方法是有返回值的
+ thenCompose :将上一个Future实例结果传递给下一个实例中


```
@RestController
public class CompletableFutureCompose {

    @Resource
    private ThreadPoolTaskExecutor customAsyncTaskExecutor;

    @RequestMapping(value = "/thenRun")
    public void thenRun() {
        CompletableFuture.runAsync(() -> {
            System.out.println("thread name:" + Thread.currentThread().getName() + " first step...");
        }, customAsyncTaskExecutor).thenRun(() -> {
            System.out.println("thread name:" + Thread.currentThread().getName() + " second step...");
        }).thenRunAsync(() -> {
            System.out.println("thread name:" + Thread.currentThread().getName() + " third step...");
        });
    }
}

```


thenCombine和thenCompose之间的区别：
thenCombine结合两个CompletableFuture没有依赖关系，且第二个CompletableFuture不需要等第一个CompletableFuture执行完成才开始
thenCompose可以结合两个CompletableFuture对象，并将前一个任务的返回结果作为下一个任务的参数，它们之间存在着先后顺序
thenCombine()会在两个任务都执行完成之后，把两个任务的结果合并，两个任务是并行执行的，它们之间并没有先后依赖顺序

```
@RequestMapping(value = "/thenCombine")
public void thenCombine() {
    CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
        System.out.println("执行future1开始...");
        return "Hello";
    }, asyncThreadPoolExecutor);
    CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
        System.out.println("执行future2开始...");
        return "World";
    }, asyncThreadPoolExecutor);
    future1.thenCombine(future2, (result1, result2) -> {
        String result = result1 + " " + result2;
        System.out.println("获取到future1、future2聚合结果：" + result);
        return result;
    }).thenAccept(result -> System.out.println(result));
}

@RequestMapping(value = "/thenCompose")
public void thenCompose() {
    CompletableFuture.supplyAsync(() -> {
        // 第一个Future实例结果
        System.out.println("thread name:" + Thread.currentThread().getName() + " 执行future1开始...");
        return "Hello";
    }, customAsyncTaskExecutor).thenCompose(result1 -> CompletableFuture.supplyAsync(() -> {
        // 将上一个Future实例结果传到这里
        System.out.println("thread name:" + Thread.currentThread().getName() + " 执行future2开始..., 第一个实例结果：" + result1);
        return result1 + " World";
    })).thenCompose(result12 -> CompletableFuture.supplyAsync(() -> {
        // 将第一个和第二个实例结果传到这里
        System.out.println("thread name:" + Thread.currentThread().getName() + " 执行future3开始..., 第一第二个实现聚合结果：" + result12);
        String targetResult = result12 + ", I am austin!";
        System.out.println("最终输出结果：" + targetResult);
        return targetResult;
    }));
}

```



获取CompletableFuture执行的结果：     
+ get() 阻塞式获取执行结果，如果任务还没有完成则会阻塞等待直到任务执行完成
+ get(long timeout,TimeUnit unit):带超时的阻塞时获取执行结果
+ getNow()如果已经完成，立刻返回执行结果，否则返回给定的valueIfAbsent
+ join() 和get()方法一样，不抛出异常的阻塞式获取异步执行结果
+ allOf()  当给定的所有的CompletableFuture都完成时，返回一个新的CompletableFuture
+ anyOf()  当给定的其中一个CompletableFuture完成时，返回一个新的CompletableFuture

join()和get()方法都是阻塞式的调用他们的线程（通常是主线程）来获取CompletableFuture异步之后的返回值
两者的区别在于join（）返回计算的结果或者抛出一个unchecked异常CompletionException而get()返回一个具体的异常

结果处理：
```
public CompletableFuture<T> whenComplete(BiConsumer<? super T,? super Throwable> action) 
public CompletableFuture<T> whenCompleteAsync(BiConsumer<? super T,? super Throwable> action) 
public CompletableFuture<T> whenCompleteAsync(BiConsumer<? super T,? super Throwable> action, Executor executor)

```

异常处理：
使用CompletableFuture时，异常处理很重要，CompletableFuture提供三种方式处理，handle()  whenComplete()   exceptionly()
handle(): 返回一个新的CompletionStage,当该阶段正常或者异常完成时，将使用此阶段的结果和异常作为所提供函数的参数执行，不会将内部异常抛出
whenComplete：返回与此阶段具有相同结果或异常的新CompletionStage，该阶段在此阶段完成时执行给定操作。与方法handle不同，会将内部异常往外抛出。
exceptionally：返回一个新的CompletableFuture，CompletableFuture提供了异常捕获回调exceptionally，相当于同步调用中的try/catch。














































