package com.company.myapiadminx.security;

import io.jmix.security.model.EntityAttributePolicyAction;
import io.jmix.security.model.EntityPolicyAction;
import io.jmix.security.role.annotation.EntityAttributePolicy;
import io.jmix.security.role.annotation.EntityPolicy;
import io.jmix.security.role.annotation.ResourceRole;
import io.jmix.security.role.annotation.SpecificPolicy;
import io.jmix.securityui.role.annotation.MenuPolicy;
import io.jmix.securityui.role.annotation.ScreenPolicy;

import static io.jmix.security.model.EntityPolicyAction.READ;

@ResourceRole(name="REST: Read Only", code=ReadAccessRole.CODE)
public interface ReadAccessRole {
    String CODE = "read-only";
    @EntityPolicy(entityName = "*", actions = {READ})
    void ReadAccessRole();
}
