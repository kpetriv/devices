## Requirements

Android 13
Coroutines, Retrofit
Secure Key storage: EncryptedSharedPreferences
Show a list of devices paginated: user name, last scan date, access code
Search feature: search by user name

## API

URL: https://hiring.iverify.io/device @Post
Params: pageNumber: Int , pageSize: Int = 100 (max = 1000)
Example DTO response: 
```json
[
  {
    "accessCode": "3PH8HR",
    "name": "Bob Hall",
    "lastScanDate": "2024-11-22T19:01:30.244050"
  }
]
```
