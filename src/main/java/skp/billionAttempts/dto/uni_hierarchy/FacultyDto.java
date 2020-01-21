package skp.billionAttempts.dto.uni_hierarchy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import skp.billionAttempts.model.uni_hierarchy.Faculty;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class FacultyDto {
    private Long id;
    private String facultyName;
    private List<DirectionDto> directions;

    public static FacultyDto fromFaculty(Faculty faculty) {
        FacultyDto facultyDto = new FacultyDto();
        facultyDto.setId(faculty.getId());
        facultyDto.setDirections(getDirectionDtos(faculty));
        facultyDto.setFacultyName(faculty.getName());
        return facultyDto;
    }

    public static List<FacultyDto> fromFaculties(List<Faculty> faculties) {
        return faculties.stream().map(FacultyDto::fromFaculty).collect(Collectors.toList());
    }

    private static List<DirectionDto> getDirectionDtos(Faculty faculty) {
        return DirectionDto.fromDirections(faculty.getDirections());
    }

}
