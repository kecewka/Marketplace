package com.example.marketplace.keycloak;

import com.example.marketplace.dao.UserRepository;
import com.example.marketplace.entity.User;
import org.keycloak.component.ComponentModel;
import org.keycloak.credential.CredentialInput;
import org.keycloak.credential.CredentialInputUpdater;
import org.keycloak.credential.CredentialInputValidator;
import org.keycloak.credential.CredentialModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserCredentialModel;
import org.keycloak.models.UserModel;
import org.keycloak.models.credential.PasswordCredentialModel;
import org.keycloak.storage.StorageId;
import org.keycloak.storage.UserStorageProvider;
import org.keycloak.storage.user.UserLookupProvider;

import java.util.Collections;
import java.util.Set;

public class CustomUserStorageProvider implements UserStorageProvider, UserLookupProvider, CredentialInputValidator, CredentialInputUpdater {

    private final KeycloakSession session;
    private final ComponentModel model;
    private final CustomUserService customUserService;


    public CustomUserStorageProvider(KeycloakSession session, ComponentModel model, CustomUserService repository) {
        this.session = session;
        this.model = model;
        this.customUserService = repository;
    }

    // CredentialInputUpdater Methods

    @Override
    public boolean updateCredential(RealmModel realmModel, UserModel userModel, CredentialInput credentialInput) {
        if (!supportsCredentialType(credentialInput.getType()) || !(credentialInput instanceof UserCredentialModel)) {
            return false;
        }
        UserCredentialModel cred = (UserCredentialModel) credentialInput;
        return customUserService.updateCredentials(userModel.getUsername(), cred.getChallengeResponse());
    }

    @Override
    public void disableCredentialType(RealmModel realmModel, UserModel userModel, String s) {

    }

    @Override
    public Set<String> getDisableableCredentialTypes(RealmModel realmModel, UserModel userModel) {
        return Collections.EMPTY_SET;
    }

    // CredentialInputValidator methods

    @Override
    public boolean supportsCredentialType(String s) {
        return PasswordCredentialModel.TYPE.equals(s);
    }


    @Override
    public boolean isConfiguredFor(RealmModel realmModel, UserModel userModel, String s) {
        return supportsCredentialType(s);
    }

    @Override
    public boolean isValid(RealmModel realmModel, UserModel userModel, CredentialInput credentialInput) {
        if (!supportsCredentialType(credentialInput.getType()) || !(credentialInput instanceof UserCredentialModel)) {
            return false;
        }

        UserCredentialModel cred = (UserCredentialModel) credentialInput;
        return customUserService.validateCredentials(userModel.getUsername(), cred.getChallengeResponse());

    }

    // UserLookupProvider methods

    @Override
    public UserModel getUserById(String s, RealmModel realmModel) {
        String externalId = StorageId.externalId(s);
        return new CustomUserAdapter(session, realmModel, model, customUserService.findById(Integer.valueOf(externalId)));
    }

    @Override
    public UserModel getUserByUsername(String s, RealmModel realmModel) {
        User user = customUserService.findByUsername(s);
        if (user != null) {
            return new CustomUserAdapter(session, realmModel, model, user);
        }
        return null;

    }

    @Override
    public UserModel getUserByEmail(String s, RealmModel realmModel) {
        return null;
    }

    @Override
    public void close() {

    }
}
