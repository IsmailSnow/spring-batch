package org.id.bankspringbatch.controller;


import lombok.AllArgsConstructor;
import org.id.bankspringbatch.config.BankTransactionItemAnalyticsProcessor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class BankRestController {

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;

    @Autowired
    private BankTransactionItemAnalyticsProcessor analyticsProcessor;


    @RequestMapping("/loadData")
    public BatchStatus load() throws Exception{
        Map<String, JobParameter> parameterMap = new HashMap<>();
        parameterMap.put("time",new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(parameterMap);
        JobExecution jobExecution = jobLauncher.run(job,jobParameters);
        while(jobExecution.isRunning()){
            System.out.println("....");
        }
        return jobExecution.getStatus();
    }

    @RequestMapping("/analytics")
    public Map<String,Double> analytics(){
        Map<String, Double> parameterMap = new HashMap<>();
        parameterMap.put("totalDebit",analyticsProcessor.getTotalDebit());
        parameterMap.put("totalCredit",analyticsProcessor.getTotalCredit());
        return  parameterMap;
    }

}
