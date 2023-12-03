//package com.jframe.basic.acc.config;
//
//import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
//import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.Resource;
//import javax.sql.DataSource;
//
///**
// * @Author: Jimmy He
// * @Date: 2023/5/14 22:36
// * @Description: TODO 描述
// */
//@Configuration
//@MapperScan("com.jframe.basic.acc.gatewayimpl.database.mapper")
//public class MybatisPlusConfig {
//    /**
//     * inject pagination interceptor.
//     *
//     * @return pagination
//     */
//    @Bean
//    public PaginationInnerInterceptor paginationInnerInterceptor() {
//        return new PaginationInnerInterceptor();
//    }
//
//    /**
//     * add pagination interceptor.
//     *
//     * @return MybatisPlusInterceptor
//     */
//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
//        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor());
//        return mybatisPlusInterceptor;
//    }
//
//}
