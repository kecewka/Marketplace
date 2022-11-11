package com.example.marketplace.keycloak;

import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.storage.UserStorageProviderFactory;

public class CustomUserStorageProviderFactory implements UserStorageProviderFactory<CustomUserStorageProvider> {

    private final CustomUserService customUserService;

    public CustomUserStorageProviderFactory(CustomUserService customUserService) {
        this.customUserService = customUserService;
    }

    @Override
    public CustomUserStorageProvider create(KeycloakSession keycloakSession, ComponentModel componentModel) {
        return new CustomUserStorageProvider(keycloakSession, componentModel, customUserService);
    }

    @Override
    public String getId() {
        return "marketplace-app-provider";
    }
}
