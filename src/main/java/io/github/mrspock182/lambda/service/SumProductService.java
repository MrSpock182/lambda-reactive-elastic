package io.github.mrspock182.lambda.service;

import io.github.mrspock182.lambda.repository.orm.Order;

public interface SumProductService {
    Order sum(Order order);
}
