# Maven Central sample

A minimal Java library (`io.github.dhairya-grid:central-sample`) set up to publish
to Maven Central. It exists to prove the publishing setup before the real SDK
goes there.

## Use it

```xml
<dependency>
  <groupId>io.github.dhairya-grid</groupId>
  <artifactId>central-sample</artifactId>
  <version>0.1.0</version>
</dependency>
```

No `<repository>` entry is needed: Maven and Gradle read Maven Central by default.

## One-time setup

1. **Account:** sign in at https://central.sonatype.com **with GitHub**, as
   `dhairya-grid`.
2. **Namespace:** check *Namespaces* shows `io.github.dhairya-grid` as
   verified. Signing in with GitHub creates it; if it is missing, add it and
   create the temporary public repo Central names under `dhairya-grid`.
3. **Signing key:** create a GPG key, publish its public half to a keyserver
   (`gpg --keyserver keyserver.ubuntu.com --send-keys <KEY_ID>`), and keep the
   private half and its passphrase for the secrets below.
4. **Token:** under *Account → Generate User Token*, create a publishing token.
5. **Secrets** (in this repo, Settings → Secrets and variables → Actions):

   | Secret | Value |
   | --- | --- |
   | `CENTRAL_USERNAME` | the token's username |
   | `CENTRAL_TOKEN` | the token's password |
   | `GPG_PRIVATE_KEY` | `gpg --armor --export-secret-keys <KEY_ID>` |
   | `GPG_PASSPHRASE` | the key's passphrase |

## Release

1. Set `<version>` in `pom.xml` to the release (for example `0.1.0`) and commit.
2. Tag and push: `git tag v0.1.0 && git push origin v0.1.0`.
3. The workflow uploads and validates the bundle, then stops.
4. On https://central.sonatype.com → *Deployments*, check it and press
   **Publish** (or **Drop** to discard). It reaches Maven Central in about
   30 minutes.

A published version is permanent: it can never be deleted or replaced, so
each release needs a new version number.

## Check a release locally without uploading

```bash
mvn -Prelease verify
```

This builds and GPG-signs everything Central needs (jar, sources, javadoc and
POM, each with a `.asc` signature) into `target/`, and stops before the upload
step. It needs a local GPG key.
