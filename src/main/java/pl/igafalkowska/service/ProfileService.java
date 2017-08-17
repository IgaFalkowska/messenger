package pl.igafalkowska.service;


import pl.igafalkowska.database.Database;
import pl.igafalkowska.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {
    private static Map<String, Profile> profiles = Database.getProfiles();

    public ProfileService() {
        profiles.put("olek", new Profile(1l, "olek", "Aleksander", "Kowalski", "o.kowalski@gmail.com", 1890));
    }

    public List<Profile> getProfiles() {
        return new ArrayList<>(profiles.values());
    }

    public Profile getProfile(String profileName) {
        return profiles.get(profileName);
    }

    public Profile addProfile(Profile profile) {
        profile.setId(profiles.size() + 1);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile) {
        if (profile.getProfileName().isEmpty()) {
            return null;
        } else {
            profiles.put(profile.getProfileName(), profile);
            return profile;
        }
    }

    public void deleteProfile(String profileName) {
        profiles.remove(profileName);
    }
}
