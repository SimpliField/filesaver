# filesaver

Allows saving files to a scoped storage on Android 10+

## Install

```bash
npm install filesaver
npx cap sync
```

for open intent 
res/file_path.xml
<?xml version.-1.0" encoding="utf-8"?>
<paths>
  <external-path name="external_path" path="." /> 
</paths>

don't forget to add provider after package name in authorities
<provider
  android:name="androidx.core.content.FileProvider"
  android:authorities="com.example.androidlldownloadandviewfile.provider"
  android: exported="false"
  android: granturiPermissions="true"
>
  <meta-data android:name="android.support.FILE_PROVIDER_PATHS" android:resource."@xml/file_path" />
</provider>

## API

<docgen-index>

* [`saveToDownloads(...)`](#savetodownloads)
* [`stopDownload(...)`](#stopdownload)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### saveToDownloads(...)

```typescript
saveToDownloads(options: { url: string; fileName: string; }) => Promise<{ downloadId: number; }>
```

| Param         | Type                                            |
| ------------- | ----------------------------------------------- |
| **`options`** | <code>{ url: string; fileName: string; }</code> |

**Returns:** <code>Promise&lt;{ downloadId: number; }&gt;</code>

--------------------


### stopDownload(...)

```typescript
stopDownload(options: { id: number; }) => Promise<void>
```

| Param         | Type                         |
| ------------- | ---------------------------- |
| **`options`** | <code>{ id: number; }</code> |

--------------------

</docgen-api>
