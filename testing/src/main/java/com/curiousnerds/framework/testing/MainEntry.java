package com.curiousnerds.framework.testing;

import com.curiousnerds.streams.tests.test5.ProblemTest;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.File;
import java.nio.file.Paths;
import java.util.Collections;

import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.*;


public class MainEntry {
    public static void main(String[] args) {

        SummaryGeneratingListener listener = new SummaryGeneratingListener();

        File classesDir = new File("/Users/abhiram/IdeaProjects/judge-dredd/testing/out/production/classes");
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClasspathRoots(Collections.singleton(Paths.get(classesDir.toURI()))))
                .filters(includeClassNamePatterns(".*"))
                .build();

        Launcher launcher = LauncherFactory.create();
        TestPlan testPlan = launcher.discover(request);
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
        TestExecutionSummary summary = listener.getSummary();
    }


}

