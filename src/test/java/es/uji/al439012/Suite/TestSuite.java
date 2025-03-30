package es.uji.al439012.Suite;

import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Lanzar todos los tests")
@SelectPackages({
        "es.uji.al439012.csv",
        "es.uji.al439012.KNN",
        "es.uji.al439012.table",
        "es.uji.al439012.KMeans",
        "es.uji.al439012.recSys"
})
@IncludeClassNamePatterns(".*Test")
public class TestSuite {
}

