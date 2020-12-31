package com.leo.ibatis.entity;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/12/23
 * @description
 */

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "service1")
public class ServiceImplOne implements IService{
}
