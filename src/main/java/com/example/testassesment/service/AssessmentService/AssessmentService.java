package com.example.testassesment.service.AssessmentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class AssessmentService {

    /**
     * "categories": [
     * <p>
     * ],
     * "created_at": "2020-01-05 13:42:25.352697",
     * "icon_url": "https://assets.chucknorris.host/img/avatar/chuck-norris.png",
     * "id": "NhalBjqFS6COQsskeoWhOQ",
     * "updated_at": "2020-01-05 13:42:25.352697",
     * "url": "https://api.chucknorris.io/jokes/NhalBjqFS6COQsskeoWhOQ",
     * "value": "Chuck Norris can create a rock so heavy that he couldn't lift it, and then lift it."
     */
    public Set retrieveRandomObject() throws ExecutionException, InterruptedException {
        Set<Object> list = new LinkedHashSet<>() ;

        while (list.size()<=24) {
            CompletableFuture<Object> future = asyncHttpCall(HttpMethod.GET, "https://api.chucknorris.io/jokes/random", "", Map.of()) ;
            list.add(future.get());
        }

        return list;
    }

    private CompletableFuture<Object> asyncHttpCall(HttpMethod httpMethod, String url, String body, Map<String, String> headers) {

        return WebClient.create(url).method(httpMethod).bodyValue(body).headers(httpHeaders -> headers.forEach(httpHeaders::add))
                .retrieve()
                .bodyToMono(Object.class)
                // specify timeout
                .timeout(Duration.ofSeconds(5L))
                // subscribe on a different thread from the given scheduler to avoid blocking as toFuture is a subscriber
                .subscribeOn(Schedulers.single())
                // subscribes to the mono and converts it to a completable future
                .toFuture();
    }

}
