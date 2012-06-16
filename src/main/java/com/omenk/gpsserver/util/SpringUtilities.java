package com.omenk.gpsserver.util;


import com.omenk.gpsserver.dao.PositionDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtilities {

    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        applicationContext = new ClassPathXmlApplicationContext("classpath*:/META-INF/spring/applicationContext.xml");
        return applicationContext;
    }

//	public static MahasiswaDao getMahasiswaDao(){
//		return (MahasiswaDao)getApplicationContext().getBean("mahasiswaDao");
//	}
    public static PositionDAO getPositionDAO() {
        return (PositionDAO) getApplicationContext().getBean("positionDAOImpl");
    }

  

}
