package org.watertemplate.site.templates.pages.examples;

import org.watertemplate.Template;
import org.watertemplate.TemplateMap;
import org.watertemplate.site.templates.GlobalMaster;

public class Examples extends Template {
    public static final String PATH = "/examples";

    @Override
    protected void addSubTemplates(TemplateMap.SubTemplates subTemplates) {
        subTemplates.add("examples_list", new ExamplesList());
    }

    @Override
    protected Template getMasterTemplate() {
        return new Master(new Header());
    }

    @Override
    protected String getFilePath() {
        return "pages/examples/examples.html";
    }


    //


    private static class Header extends Template {
        @Override
        protected Template getMasterTemplate() {
            return new GlobalMaster.Header();
        }

        @Override
        protected String getFilePath() {
            return "pages/examples/header.html";
        }
    }
}
