
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
```
MIT License

Copyright (c) 2022 Mohammad Fahmi

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
