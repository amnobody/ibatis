package com.leo.ibatis.entity;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author ChenJiWei
 * @version V1.0
 * @date 2020/12/23
 * @description
 */
@Service
@Qualifier(value = "service1")
public class ServiceImplTwo implements IService{
}
