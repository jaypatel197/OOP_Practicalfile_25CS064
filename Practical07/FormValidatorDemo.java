import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class SignupForm {
    @NotBlank
    @MaxLength(8)
    String username;

    @NotBlank
    String email;

    SignupForm(String username, String email) {
        this.username = username;
        this.email = email;
    }
}

public class FormValidatorDemo {
    public static ArrayList<String> validate(Object obj) throws Exception {
        ArrayList<String> errors = new ArrayList<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field f : fields) {
            f.setAccessible(true);
            Object val = f.get(obj);
            String str = val == null ? "" : val.toString();

            if (f.isAnnotationPresent(NotBlank.class) && str.trim().isEmpty()) {
                errors.add(f.getName() + " cannot be blank");
            }
            if (f.isAnnotationPresent(MaxLength.class)) {
                int max = f.getAnnotation(MaxLength.class).value();
                if (str.length() > max) {
                    errors.add(f.getName() + " exceeds max length " + max);
                }
            }
        }
        return errors;
    }

    public static void main(String[] args) throws Exception {
        SignupForm form = new SignupForm("SuperLongName", "");
        ArrayList<String> errs = validate(form);

        for (String err : errs) {
            System.out.println("Error: " + err);
        }
    }
}