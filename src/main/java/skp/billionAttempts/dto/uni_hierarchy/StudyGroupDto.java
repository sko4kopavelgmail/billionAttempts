package skp.billionAttempts.dto.uni_hierarchy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import skp.billionAttempts.model.uni_hierarchy.StudyGroup;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
public class StudyGroupDto {
    private Long id;
    private String groupName;

    public static StudyGroupDto fromStudyGroup(StudyGroup studyGroup) {
        StudyGroupDto studyGroupDto = new StudyGroupDto();
        studyGroupDto.setId(studyGroup.getId());
        studyGroupDto.setGroupName(studyGroup.getName());
        return studyGroupDto;
    }

    public static List<StudyGroupDto> fromStudyGroups(List<StudyGroup> studyGroups) {
        return studyGroups.stream().map(StudyGroupDto::fromStudyGroup).collect(Collectors.toList());
    }
}
