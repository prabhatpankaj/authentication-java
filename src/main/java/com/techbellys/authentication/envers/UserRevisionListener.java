package com.techbellys.authentication.envers;

import com.techbellys.authentication.service.AppUserService;
import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class UserRevisionListener implements RevisionListener {
    @Override
    public void newRevision(Object revisionEntity) {
        AuditEnversInfo auditEnversInfo = (AuditEnversInfo) revisionEntity;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            // Return system-generated auditor if no authenticated user is found
            auditEnversInfo.setUsername("System");
        }

        // Return the name of the authenticated user
        assert authentication != null;
        auditEnversInfo.setUsername(authentication.getName());

    }
}
