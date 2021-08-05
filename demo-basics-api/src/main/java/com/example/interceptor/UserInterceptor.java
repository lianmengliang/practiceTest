package com.example.interceptor;

import com.example.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ： leo
 * @Date :2019/11/6 15:41
 */
@Component
public class UserInterceptor implements HandlerInterceptor {

    /**
     * 进入controller层之前拦截请求
     * 返回值：表示是否将当前的请求拦截下来  false：拦截请求，请求别终止。true：请求不被拦截，继续执行
     * Object obj:表示被拦的请求的目标对象（controller中方法）
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        System.out.println("执行到了preHandle方法");
        System.out.println(handler);
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod method = (HandlerMethod) handler;
        if (!method.getBeanType().isAnnotationPresent(Controller.class) && !method.getBeanType()
                .isAnnotationPresent(
                        RestController.class)) {
            return true;
        }
        User user = (User) request.getSession().getAttribute("session_user");
        if (user == null) {
            //拦截后 跳转到登录页面
            response.sendRedirect(request.getContextPath() + "/user/toIndex");
            System.out.println("已成功拦截并发生跳转");
            return false;
        }



        return true;


    }

    /**
     * 处理请求完成后视图渲染之前的处理操作
     * 通过ModelAndView参数改变显示的视图，或发往视图的方法
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("执行了postHandle方法");
    }

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {

        System.out.println("执行了afterCompletion方法");
    }
}
