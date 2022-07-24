//package com.lab.springlab.DI;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class SampleService {
//
////    private final newSampleService newSampleService;
////
////    // 순환 참조 발생
////    @Autowired
////    public SampleService(newSampleService newSampleService) {
////        this.newSampleService = newSampleService;
////    }
//
//    private final SampleRepository sampleRepository;
//
//    // 단일 생성자이기 떄문에 @Autowired 생략
//    public SampleService(SampleRepository sampleRepository) {
//        this.sampleRepository = sampleRepository;
//    }
//}
