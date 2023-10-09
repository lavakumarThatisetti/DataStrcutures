package Java8Features;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFutureExample {
    public static Future<String> caluclateAsync(){
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(()->{
            try {
                Thread.sleep(500);
                completableFuture.complete("Hello");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        return completableFuture;
    }
    public static void main(String[] args) throws Exception {
          Future<String> completableFuture = caluclateAsync();
          String str = completableFuture.get();
          System.out.println(str);
          CompletableFuture<String> future  = CompletableFuture.supplyAsync(()->"Hello");
          System.out.println(future.get().equals("Hello"));
          // Then Apply process the result of a computation is to feed it to a function
          CompletableFuture<String> addString = future.thenApply(s->s+" world");
          System.out.println(addString.get());
          // Then Accept method receives a Consumer and passes it the result of the computation
          CompletableFuture<Void>  acceptFuture = future.thenAccept(s -> System.out.println("Computation returned "+ s));
          // Combining Futures ThenCompose
          CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(()->"Hello")
                  .thenCompose(s->CompletableFuture.supplyAsync(()-> s + " World"));
          System.out.println(completableFuture1.get());
         /* If we want to execute two independent Futures and do something with their results,
          we can use the thenCombine method that accepts a Future and a Function with two arguments
          to process both results*/
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(()->"Hello")
                .thenCombine(CompletableFuture.supplyAsync(()->" World"),(s1,s2)-> s1+s2);
        System.out.println(completableFuture2.get());

        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> combinedFuture
                = CompletableFuture.allOf(future1, future2, future3);

        combinedFuture.get();

        String combined = Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));
        System.out.println(combined);

    }
}
