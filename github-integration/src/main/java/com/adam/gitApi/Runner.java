package com.adam.gitApi;

import java.io.IOException;
import java.util.List;
import org.kohsuke.github.GHMyself;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;


public class Runner {

  public static void main(String[] args) throws IOException {

    GitHub gitHub = new GitHubBuilder()
        .withOAuthToken("myToken", "VolodymyrAdamenko").build();
    GHMyself person = gitHub.getMyself();
    List<GHRepository> myStarredRepoList = person.listStarredRepositories().asList();
    List<GHRepository> myGhRepoList = person.listRepositories().asList();
    for (GHRepository myRepo : myGhRepoList) {
      System.out.println("My repository: " + myRepo.getName());
    }
    for (GHRepository starsRepo : myStarredRepoList) {
      System.out.println("My starred repository: " + starsRepo.getName());
    }

  }
}
