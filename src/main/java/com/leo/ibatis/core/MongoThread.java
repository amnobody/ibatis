package com.leo.ibatis.core;

/**
 * DESC:
 *
 * @author JiWei.Chen
 * @date 2020/08/07
 */
public class MongoThread implements Runnable{

    private MongoService mongoService;

    public MongoThread(MongoService mongoService) {
        this.mongoService = mongoService;
    }

    @Override
    public void run() {
        mongoService.save();
    }
}
