package com.example.demo;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;
import org.springframework.cloud.kubernetes.client.KubernetesClientUtils;
import org.springframework.cloud.kubernetes.commons.KubernetesClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 王志平
 * @date 2021/12/22 10:48 AM
 */
@Configuration
public class K8sConfig {
    @Bean
    public ApiClient apiClient(KubernetesClientProperties properties) throws IOException {
        String configPath = "/Users/wzp/.kube/config";

       return ClientBuilder
               .kubeconfig(KubeConfig.loadKubeConfig(new FileReader(configPath)))
               .build();
//        ApiClient apiClient = KubernetesClientUtils.kubernetesApiClient();
//        apiClient.setUserAgent(properties.getUserAgent());
      //  return apiClient;
    }
}
