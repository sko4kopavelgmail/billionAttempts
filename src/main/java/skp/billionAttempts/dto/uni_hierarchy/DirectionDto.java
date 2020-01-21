package skp.billionAttempts.dto.uni_hierarchy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import skp.billionAttempts.model.uni_hierarchy.Direction;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class DirectionDto {
    private Long id;
    private String directionName;
    List<StudyGroupDto> studyGroups;

    public static DirectionDto fromDirection(Direction direction) {
        DirectionDto directionDto = new DirectionDto();
        directionDto.setDirectionName(direction.getName());
        directionDto.setId(direction.getId());
        directionDto.setStudyGroups(getStudyGroupDtos(direction));
        return directionDto;
    }

    public static List<DirectionDto> fromDirections(List<Direction> directions) {
        return directions.stream().map(DirectionDto::fromDirection).collect(Collectors.toList());
    }

    private static List<StudyGroupDto> getStudyGroupDtos(Direction direction) {
        return StudyGroupDto.fromStudyGroups(direction.getGroups());
    }

}
