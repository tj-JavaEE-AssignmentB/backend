package com.tj_JavaEE.service.impl;

import com.tj_JavaEE.mapper.FeedbackMapper;
import com.tj_JavaEE.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceimpl implements FeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;
}
