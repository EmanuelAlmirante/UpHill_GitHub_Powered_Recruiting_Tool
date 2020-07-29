package recruitingtool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import recruitingtool.model.AdminModel;
import recruitingtool.repository.AdminRepository;

@Component
public class DataLoader implements ApplicationRunner {
    private final AdminRepository adminRepository;

    @Autowired
    public DataLoader(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void run(ApplicationArguments args) {
        AdminModel admin = new AdminModel();
        admin.setUserName("root");
        admin.setPassword("root");

        adminRepository.save(admin);
    }
}
