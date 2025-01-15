int hardestWorker(int n, int** logs, int logsSize, int* logsColSize) {
    int maxTime = 0;
    int result = n;  
    int prevTime = 0; 

    for (int i = 0; i < logsSize; i++) {
        int empId = logs[i][0];        
        int logTime = logs[i][1];     
        int duration = logTime - prevTime;
        
        if (duration > maxTime || (duration == maxTime && empId < result)) {
            maxTime = duration; 
            result = empId;     
        }
        prevTime = logTime;
    }
    
    return result;
}