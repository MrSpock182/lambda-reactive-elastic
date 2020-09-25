package io.github.mrspock182.lambda.service.implementation;

import io.github.mrspock182.lambda.repository.orm.Order;
import io.github.mrspock182.lambda.service.SumProductService;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
public class SumProductServiceImpl implements SumProductService {

    @Override
    public Order sum(Order order) {
        AtomicReference<Double> value = new AtomicReference<>(0.0);
        order.getProducts().parallelStream().forEach(o -> value.updateAndGet(v -> v + o.getPrice()));
        return new Order(order.getId(), order.getClientName(), order.getProducts(), value.get());
    }
}
