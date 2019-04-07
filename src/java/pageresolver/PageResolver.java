package pageresolver;

import constants.Constants;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Nikola
 */
public class PageResolver {

    private static PageResolver instance;
    private Map<String, String> views;

    public static PageResolver getInstance() {
        if (instance == null) {
            instance = new PageResolver();
        }
        return instance;
    }

    public String getView(String key) {
        return views.get(key);
    }

    private PageResolver() {
        views = new HashMap<>();
        views.put("login", "/login.jsp");
        views.put("login_user", "/WEB-INF/pages/login.jsp");
        views.put("index", "/WEB-INF/pages/index.jsp");
        views.put("all_employees", "/WEB-INF/pages/all_employees.jsp");
        views.put("add_employee", "/WEB-INF/pages/add_employee.jsp");
        views.put("all_subjects", "/WEB-INF/pages/all_subjects.jsp");
        views.put("all_employee_sub", "/WEB-INF/pages/all_employee_sub.jsp");
        views.put("all_literature", "/WEB-INF/pages/all_literature.jsp");
        views.put("get_authors_lit", "/WEB-INF/pages/authors_lit.jsp");
        views.put("add_literature", "/WEB-INF/pages/add_literature.jsp");
        views.put("add_employee_role", "/WEB-INF/pages/add_employee_role.jsp");
        views.put("all_departments_user", "/WEB-INF/pages/all_departments_user.jsp");
        views.put("index_user", "/index_user.jsp");
        views.put("all_inf_user", "/WEB-INF/pages/all_inf_user.jsp");
        views.put("all_employees_user", "/WEB-INF/pages/all_employees_user.jsp");
        views.put("all_subjects_user", "/WEB-INF/pages/all_subjects_user.jsp");
        views.put("all_employee_sub_user", "/WEB-INF/pages/all_employee_sub_user.jsp");
        views.put("all_literature_sub_user", "/WEB-INF/pages/all_literature_sub_user.jsp");
        views.put("update_employee", "/WEB-INF/pages/update_employee.jsp");
        views.put("subjects_details_user", "/WEB-INF/pages/subjects_details_user.jsp");
        views.put("get_all_literature", "/WEB-INF/pages/get_all_literature.jsp");
        views.put("add_publisher", "/WEB-INF/pages/add_publisher.jsp");
        views.put("add_author", "/WEB-INF/pages/add_author.jsp");
        views.put("add_literature_sub", "/WEB-INF/pages/add_literature_sub.jsp");
        views.put("update_literature", "/WEB-INF/pages/update_literature.jsp");

    }

}
