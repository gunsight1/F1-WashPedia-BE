package com.kernel360.member.dto;

import com.kernel360.member.command.MemberCommand;

import java.time.LocalDate;

/**
 * DTO for {@link com.kernel360.member.command.MemberCommand}
 */
public record MemberDto(Long memberNo,
                        String id,
                        String email,
                        String password,
                        String gender,
                        String age,
                        LocalDate createdAt,
                        String createdBy,
                        LocalDate modifiedAt,
                        String modifiedBy,
                        String jwtToken
) {

    public static MemberDto of(
            Long memberNo,
            String id,
            String email,
            String password,
            String gender,
            String age,
            LocalDate createdAt,
            String createdBy,
            LocalDate modifiedAt,
            String modifiedBy,
            String jwtToken
    ) {
        return new MemberDto(
                memberNo,
                id,
                email,
                password,
                gender,
                age,
                createdAt,
                createdBy,
                modifiedAt,
                modifiedBy,
                jwtToken
        );
    }

    public static MemberDto from(MemberCommand command) {
        return MemberDto.of(
                command.getMemberNo(),
                command.getId(),
                command.getEmail(),
                command.getPassword(),
                command.getGender(),
                command.getAge(),
                command.getCreatedAt(),
                command.getCreatedBy(),
                command.getModifiedAt(),
                command.getModifiedBy(),
                null
        );
    }

    public MemberCommand toCommand() {
        return MemberCommand.of(
                this.memberNo(),
                this.id(),
                this.email(),
                this.password(),
                this.gender(),
                this.age()
        );
    }

    /** joinMember **/
    public static MemberDto of(
            String id,
            String email,
            String password,
            String gender,
            String   age
    ){
        return new MemberDto(
                null,
                id,
                email,
                password,
                gender,
                age,
                null,
                null,
                null,
                null,
                null
        );
    }

    /** Login Binding **/
    public static MemberDto login(MemberCommand command, String jwtToken) {
        return MemberDto.of(
                command.getMemberNo(),
                command.getId(),
                command.getEmail(),
                null,
                command.getGender(),
                command.getAge(),
                command.getCreatedAt(),
                command.getCreatedBy(),
                command.getModifiedAt(),
                command.getModifiedBy(),
                jwtToken
        );
    }

    /** Request Login **/
    public static MemberDto of(
            String id,
            String password
    ){
        return new MemberDto(
                null,
                id,
                null,
                password,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }
}