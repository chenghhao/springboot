import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.baomidou.mybatisplus.generator.config.rules.DateType.ONLY_DATE;

public class CodeGenerator {

    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        final String projectPath = System.getProperty("user.dir") + "/knet-domain-orm";
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("xuxiannian");
        gc.setOpen(false);
        //设置使用Date类型接收日期
        gc.setDateType(ONLY_DATE);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        //生成service
        gc.setServiceName("%sService");			//service 命名方式   默认值：null 例如：%sBusiness 生成 UserBusiness
        gc.setServiceImplName("%sServiceImpl");	//service impl 命名方式  默认值：null 例如：%sBusinessImpl 生成 UserBusinessImpl
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:oracle:thin:@default.test.db.knet.cn:1521:oragbk");
        // dsc.setSchemaName("public");
        dsc.setDriverName("oracle.jdbc.driver.OracleDriver");
        dsc.setUsername("knet");
        dsc.setPassword("knet43");
        dsc.setTypeConvert(new OracleTypeConvert(){
            @Override
            public DbColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                if ( fieldType.toLowerCase().contains( "clob" ) ||fieldType.toLowerCase().contains( "blob" ) ) {
                    System.out.println("转换类型：" + fieldType);
                    return DbColumnType.STRING;
                }
                return (DbColumnType) super.processTypeConvert(globalConfig, fieldType);
            }
        });
        mpg.setDataSource(dsc);

        // 包配置
        final PackageConfig pc = new PackageConfig();
        pc.setModuleName("");
        pc.setParent("cn.knet.domain");
        Map m = new HashMap();
        m.put("entity_path", gc.getOutputDir() + File.separator + (pc.getParent().replaceAll("\\.", "\\" + File.separator)) + "/entity");
        m.put("mapper_path", gc.getOutputDir() + File.separator + (pc.getParent().replaceAll("\\.", "\\" + File.separator)) + "/mapper");
        m.put("service_path", gc.getOutputDir() + File.separator + (pc.getParent().replaceAll("\\.", "\\" + File.separator)) + "/service");
        m.put("service_Impl_path", gc.getOutputDir() + File.separator + (pc.getParent().replaceAll("\\.", "\\" + File.separator)) + "/service/Impl");
        pc.setPathInfo(m);
        mpg.setPackageInfo(pc);
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };


        cfg.setFileOutConfigList(null);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        // 公共父类
        //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();


    }
}


