package org.wonderming.generator;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.PropertyRegistry;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2018/12/25
 * @Time: 10:58
 * @Project: youqu
 * @Package: org.wonderming.generator
 */
public class MyCommentGenerator implements CommentGenerator {

    private Properties properties;
    private boolean suppressDate;
    private boolean suppressAllComments;
    private String currentDateStr;

    public MyCommentGenerator() {
        super();
        properties = new Properties();
        suppressDate = false;
        suppressAllComments = false;
        currentDateStr = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
    }

    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);

        suppressDate = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));

        suppressAllComments = isTrue(properties
                .getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        field.addJavaDocLine("/**");
        stringBuilder.append(" * ");
        stringBuilder.append(introspectedColumn.getRemarks());
        stringBuilder.append("\n");
        stringBuilder.append("*列名:");
        stringBuilder.append(introspectedColumn.getActualColumnName());
        stringBuilder.append("类型:");
        stringBuilder.append(introspectedColumn.getJdbcTypeName());
        stringBuilder.append("(" );
        stringBuilder.append(introspectedColumn.getLength());
        stringBuilder.append(")");
        stringBuilder.append("允许空:");
        stringBuilder.append(introspectedColumn.isNullable());
        stringBuilder.append("默认值:");
        stringBuilder.append(introspectedColumn.getDefaultValue());
        field.addJavaDocLine(stringBuilder.toString());
        field.addJavaDocLine("*/");
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {

    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        if (suppressAllComments){
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/**");
        stringBuilder.append("\n");
        stringBuilder.append("*");
        stringBuilder.append("\n");
        stringBuilder.append("* @author:");
        stringBuilder.append("wonderming");
        stringBuilder.append("\n");
        if (!suppressDate) {
            stringBuilder.append("*@date");
            stringBuilder.append(currentDateStr);
            stringBuilder.append("\n");
        }
        stringBuilder.append("*数据表");
        stringBuilder.append(introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime());
        stringBuilder.append("\n" + "*/");
        topLevelClass.addJavaDocLine(stringBuilder.toString());
    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {

    }

    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {

    }

    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {

    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        String stringBuilder = "/**" +
                "\n" +
                "*" +
                introspectedColumn.getRemarks() +
                "\n" +
                "*@return" +
                introspectedColumn.getJdbcTypeName() +
                "\n" +
                "*/";
        method.addJavaDocLine(stringBuilder);
    }

    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        String stringBuilder = "/**" +
                "\n" +
                "*" + introspectedColumn.getRemarks() +
                "\n" +
                "*@param" + introspectedColumn.getJdbcTypeName() + "\n" +
                "*/";
        method.addJavaDocLine(stringBuilder);
    }

    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {

    }

    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {

    }

    @Override
    public void addComment(XmlElement xmlElement) {

    }

    @Override
    public void addRootComment(XmlElement rootElement) {

    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {

    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {

    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {

    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {

    }

    @Override
    public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> imports) {

    }
}
