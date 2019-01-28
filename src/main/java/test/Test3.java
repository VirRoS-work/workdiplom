package test;

import com.google.gson.Gson;
import model.Employer;
import model.Office;
import model.Vacancy;
import service.EmployerService;
import service.GenericService;
import service.VacancyService;

import java.util.Set;

public class Test3 {

    public static void main(String[] args) {
        Gson gson = new Gson();

        Vacancy vacancy = gson.fromJson("{\n" +
                "    \"status\": \"Активна\",\n" +
                "    \"title\": \"Java Developer\",\n" +
                "    \"description\": \"Описание вакансии\",\n" +
                "    \"salary_min\": 50000,\n" +
                "    \"salary_max\": 100000,\n" +
                "    \"remove_work\": true,\n" +
                "    \"type_employment\": \"Полный\",\n" +
                "    \"experience_min\": 2,\n" +
                "    \"employer\": {\n" +
                "        \"id\": 1\n" +
                "    },\n" +
                "    \"office\": {\n" +
                "        \"id\": null\n" +
                "    }\n" +
                "}", Vacancy.class);

        System.out.println(vacancy.toString());

        if (vacancy.getOffice() != null && vacancy.getOffice().getId() == 0){
            System.out.println("==================================");
            vacancy.setOffice(null);

        }

        VacancyService service = new VacancyService();
        service.save(vacancy);
    }
}
