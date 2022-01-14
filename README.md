
# MKA Internship Assement

Simple Native Android Applications using free Github API, that help us to search github's user, show details, and repositories.



## Authors

- [@MohFahmi27](https://www.github.com/MohFahmi27)


## API Reference

#### Search Github Users

```http
  GET /search/users
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Authorization` | `string` | **Not Required**. Your API key |
| `q` | `string` | **Not Required**. Search Query |

#### Get Detail Github User

```http
  GET /users/{username}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `Authorization` | `string` | **Not Required**. Your API key |
| `username`      | `string` | **Required**. Github Username |


#### Get User Github Repository

```http
  GET /users/{username}/repos
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Authorization` | `string` | **Not Required**. Your API key |
| `username`      | `string` | **Required**. Github Username |


## Screenshots
<p align="center"> 
  <img src="https://live.staticflickr.com/65535/51814700504_a7f8083e86_b.jpg" width="250"/>
  <img src="https://live.staticflickr.com/65535/51814700519_33a99118e3_b.jpg" width="250"/>
</p>

## License

[MIT](https://choosealicense.com/licenses/mit/)