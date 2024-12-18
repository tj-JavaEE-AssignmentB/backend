package com.tj_JavaEE.service.impl;

import com.tj_JavaEE.mapper.ReportMapper;
import com.tj_JavaEE.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceimpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;
}
