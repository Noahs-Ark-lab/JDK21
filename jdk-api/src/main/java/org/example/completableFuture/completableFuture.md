
### completaleFuture简介
CompletableFuture是有Java8引入的，之前一般使用Future实现异步。Future表示异步计算的结果，只能通过阻塞或者轮询的方式获取结果，而且不支持回调方法，Java8之前若要设置回调一般会使用guava的ListenableFuture

CompletableFuture实现了两个接口，Future<T>  CompletionStage<T> 意味着可以像之前一样通过阻塞或者轮询的方式获得结果，Future表示异步计算的结果，CompletionStage<T> 用于表示异步执行过程中的一个步骤Stage，这个步骤可能是由另外一个CompletionStage触发的，随着当前步骤的完成，也可能会触发其它一系列CompletionStage的执行

多重依赖 可以通过allOf() 或 anyOf()实现。，区别是当需要多个依赖全部完成时使用allOf(),当多个依赖中的的任意一个完成即可使用anyOf(),
```Java
CompletableFuture<Void> future6=CompletableFuture.allOf(Future3,Future4,Future5);
COmpletableFuture<String> result = Future6.thenApply(v->{
// 这里join并不会阻塞，因为传给thenApply的函数是在Future3 Future4 Future5全部完成时，才会执行
  Future3.join();
  Future4.join();
  Future5.join();
  return assamble(result3,result4,result5);
});
```
