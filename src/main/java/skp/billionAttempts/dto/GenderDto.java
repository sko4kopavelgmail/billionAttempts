package skp.billionAttempts.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import skp.billionAttempts.model.user.Gender;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class GenderDto {
    private String eName;
    private String rName;
    private String id;

    public static GenderDto fromGender(Gender gender) {
        GenderDto genderDto = new GenderDto();
        genderDto.setId(gender.getId());
        genderDto.setEName(gender.getEName());
        genderDto.setRName(gender.getRName());
        return genderDto;
    }

    public static List<GenderDto> fromGenderList(List<Gender> genders) {
        return genders.stream().map(GenderDto::fromGender).collect(Collectors.toList());
    }

}
