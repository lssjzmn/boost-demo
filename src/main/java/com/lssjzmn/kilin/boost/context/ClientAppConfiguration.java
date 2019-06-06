package com.lssjzmn.kilin.boost.context;/*
 * Copyright (c) 2012, Stephen Chin
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the <organization> nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL STEPHEN CHIN OR ORACLE CORPORATION BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class ClientAppConfiguration {


        @Bean
        RestTemplate restTemplate() {

//            SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//            requestFactory.setReadTimeout(5000);
//            requestFactory.setConnectTimeout(5000);
            // 添加转换器
            XmlFactory factory=new XmlFactory();
            List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
            messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
            messageConverters.add(new FormHttpMessageConverter());
            messageConverters.add(new MappingJackson2XmlHttpMessageConverter());
            messageConverters.add(new MappingJackson2HttpMessageConverter());

            SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//            requestFactory.setConnectTimeout(3000);
//            requestFactory.setReadTimeout(3000);
            RestTemplate restTemplate = new RestTemplate(requestFactory);
             restTemplate.setMessageConverters(messageConverters);
            restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
            return restTemplate;
         }


}
