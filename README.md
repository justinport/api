
Getting starting on docker

```   
docker run -p 8080:8080 test
```



Steps to Push Docker Image to ACR.

Install Azure CLI

```
brew update && brew install azure-cli
```
Login to Azure and ACR
```  
az login
az login acr
```


2. Create tag
``` 
docker tag b80cd9b398de csci401w.azurecr.io/api
```

3. Push to ACR

```
docker push csci401w.azurecr.io/api
```

