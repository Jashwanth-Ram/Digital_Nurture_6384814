
const BookDetails = ({books}) => {
  return (
    <div>
      <ul>
        {books.map((book)=>{
            return(
                <div key={book.id}>
                            <h3>{book.bname}</h3>
                            <h4>{book.price}</h4>
                </div>
            )
        })}
      </ul>
    </div>
  )
}

export default BookDetails
