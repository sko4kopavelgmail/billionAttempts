package skp.billionAttempts.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import skp.billionAttempts.model.user.base_user.Role;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class RoleDto {
    private String eName;
    private String rName;
    private String id;

    public static RoleDto fromRole(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setId(role.getId());
        roleDto.setRName(role.getRName());
        roleDto.setEName(role.getEName());
        return roleDto;
    }

    public static List<RoleDto> fromRoles(List<Role> values) {
        return values.stream().map(RoleDto::fromRole).collect(Collectors.toList());
    }
}
