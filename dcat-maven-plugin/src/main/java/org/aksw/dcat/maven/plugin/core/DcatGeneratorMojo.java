package org.aksw.dcat.maven.plugin.core;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Model;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
 
/**
 * Says "Hi" to the user.
 *
 */
@Mojo(name = "sayhi")
public class DcatGeneratorMojo extends AbstractMojo
{
	/** Maven session. */
    @Parameter(defaultValue = "${session}", readonly = true)
    protected MavenSession mavenSession;
	
	@Parameter
	protected String test;
	
	
	
    public void execute() throws MojoExecutionException, MojoFailureException
    {
    	Model model = MavenUtils.readModel(mavenSession.getCurrentProject());
    	
    			
        getLog().info("Hello, world. Test = " + test + " model = " + model.getArtifactId());
    }
}