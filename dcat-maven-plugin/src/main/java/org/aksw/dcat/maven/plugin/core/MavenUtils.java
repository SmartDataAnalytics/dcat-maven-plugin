package org.aksw.dcat.maven.plugin.core;

import java.io.FileReader;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;

public class MavenUtils {

    /**
     * Reads model from Maven project pom.xml.
     * 
     * @param project
     *            Maven project
     * @return Maven model
     * @throws MojoFailureException
     */
    public static Model readModel(MavenProject project) throws MojoFailureException {
        try {
            // read pom.xml
            Model model;
            FileReader fileReader = new FileReader(project.getFile().getAbsoluteFile());
            MavenXpp3Reader mavenReader = new MavenXpp3Reader();
            try {
                model = mavenReader.read(fileReader);
            } finally {
                if (fileReader != null) {
                    fileReader.close();
                }
            }
            return model;
        } catch (Exception e) {
            throw new MojoFailureException("", e);
        }
    }
}
