package com.example.marketplace.keycloak;

import com.example.marketplace.dao.UserRepository;
import org.keycloak.component.ComponentModel;
import org.keycloak.credential.CredentialInput;
import org.keycloak.credential.CredentialInputUpdater;
import org.keycloak.credential.CredentialInputValidator;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.storage.UserStorageProvider;
import org.keycloak.storage.user.UserLookupProvider;

import java.util.Set;

public class CustomUserStorageProvider implements UserStorageProvider, UserLookupProvider, CredentialInputValidator, CredentialInputUpdater {

    private final KeycloakSession session;
    private final ComponentModel model;
    private final UserRepository repository;


    public CustomUserStorageProvider(KeycloakSession session, ComponentModel model, UserRepository repository) {
        this.session = session;
        this.model = model;
        this.repository = repository;
    }

    // CredentialInputUpdater Methods

    @Override
    public boolean updateCredential(RealmModel realmModel, UserModel userModel, CredentialInput credentialInput) {
        return false;
    }

    @Override
    public void disableCredentialType(RealmModel realmModel, UserModel userModel, String s) {

    }

    @Override
    public Set<String> getDisableableCredentialTypes(RealmModel realmModel, UserModel userModel) {
        return null;
    }

    // CredentialInputValidator methods

    @Override
    public boolean supportsCredentialType(String s) {
        return false;
    }


    @Override
    public boolean isConfiguredFor(RealmModel realmModel, UserModel userModel, String s) {
        return false;
    }

    @Override
    public boolean isValid(RealmModel realmModel, UserModel userModel, CredentialInput credentialInput) {
        return false;
    }

    // UserLookupProvider methods

    @Override
    public UserModel getUserById(String s, RealmModel realmModel) {
        return null;
    }

    @Override
    public UserModel getUserByUsername(String s, RealmModel realmModel) {
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
