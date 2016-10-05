package batchboot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.File;

public class Main {

    private static final Log LOG = LogFactory.getLog(Main.class);

    private String contexts;
    public String getContexts() {
        return contexts;
    }
    public void setContexts(String contexts) {
        this.contexts = contexts;
    }

    public static void main(String... a) throws Exception {
        if (a.length == 0 || !new File(a[0]).exists()) {
            LOG.info("java -jar app.jar applicationContext.xml");
            LOG.info("java -jar app.jar applicationContext1.xml applicationContext2.xml");
            System.exit(1);
        }
        Main m=new Main();
        m.contexts=String.join(",",a);
        m.run();
    }

    public void run() throws Exception {
        LOG.info("Config...");
        ApplicationContext context = new FileSystemXmlApplicationContext(contexts.split(","));
        LOG.info("Config Done.");

        LOG.info("Job...");
        LOG.info("jobLauncher");
        LOG.info("mainJob");

        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("mainJob");

        JobExecution execution = jobLauncher.run(job, new JobParameters());
        LOG.info("Exit Status: " + execution.getStatus()); // Objeto que talvez precise ser tratado
        LOG.info("Exit Status: " + execution.getAllFailureExceptions()); // Objeto que talvez precise ser tratado
        LOG.info("Job Done.");
    }
}
