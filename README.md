# Document Classifier API

Steps to test Document Classifier

### 01. Start an instance of ****Document test API****

The instructions and the API can be found here:

**Documents API**:

[https://github.com/europace/duck-coding-challenge](https://github.com/europace/duck-coding-challenge)

**Instructions**:

[https://github.com/europace/duck-coding-challenge/blob/master/README_BACKEND.md](https://github.com/europace/duck-coding-challenge/blob/master/README_BACKEND.md)

### 02. Start an instance of **Document Classifier API**

Clone the repository. Run locally in your IDE.

### 03. To receive the following information:

- `Total number` of documents
- Number of `deleted` documents
- `Total size` of documents
- `Average size` of documents

Make **GET** request to the following URL:

> [http://localhost:8081/api/v1/documents/metadata](http://localhost:8081/api/v1/documents/metadata)
>

### 04. To`filter`documents by `category`:

Make **POST** request to the following URL:

> http://localhost:8081/api/v1/documents/filter/categories
>

The request should be in the following format:

- **Type JSON**
- **Body example**:

> {"categories":["cat_5"]}
>