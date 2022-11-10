package com.example.marketplace.keycloak;

import com.example.marketplace.entity.User;
import org.keycloak.component.ComponentModel;
import org.keycloak.credential.LegacyUserCredentialManager;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.SubjectCredentialManager;
import org.keycloak.storage.StorageId;
import org.keycloak.storage.adapter.AbstractUserAdapter;

public class CustomUserAdapter extends AbstractUserAdapter {

    private final User user;

    public CustomUserAdapter(KeycloakSession session, RealmModel realm, ComponentModel model, User user) {
        super(session, realm, model);
        this.storageId = new StorageId(storageProviderModel.getId(),String.valueOf(user.getId()));
        this.user = user;
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public SubjectCredentialManager credentialManager() {
        return new LegacyUserCredentialManager(session, realm, this);
    }
}
